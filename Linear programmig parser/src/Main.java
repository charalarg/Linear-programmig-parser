import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

	public static void main(String[] args) {
		int i=0,m=0,n=0,curr=0,max=0;
		BufferedReader br = null;
		String sCurrentLine; 
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\Χαράλαμπος\\Desktop\\test.txt"));
			char current;
			while((sCurrentLine=br.readLine()) != null){
				if(sCurrentLine.contains("max")||sCurrentLine.contains("min")){
					for(int j = 0; j < sCurrentLine.length(); j++) {
						if(sCurrentLine.charAt(j)=='+'||sCurrentLine.charAt(j)=='-'){
							n++;
						}
					}
				}
				System.out.println(sCurrentLine);
				curr=0;
				m++;
			}
			m=m-2;
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (br != null)br.close();
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("m ="+m);
		System.out.println("n ="+n);
		int line=0;
		int[] c = new int[n];
		int[] b = new int[m];
		int[][] A = new int[m][n];
		int[] Eqin = new int[m];
		int MinMax=0;
		String newLine = System.getProperty("line.separator");
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\Χαράλαμπος\\Desktop\\test.txt"));
			while((sCurrentLine=br.readLine()) != null){
				if(sCurrentLine.contains("max")||sCurrentLine.contains("min")){
					createc(sCurrentLine,n,c);
					MinMax=createMinMax(sCurrentLine);
				}
				else{
					if(sCurrentLine.contains(",")){
						
					}
					else{
						createbline(sCurrentLine,line,b);
						createAline(sCurrentLine,line,A);
						createEqin(sCurrentLine,line,Eqin);
						line++;
					}
				}
			}		
			PrintWriter writer = new PrintWriter("results.txt", "UTF-8");
			writer.println("Α:");
			for(int all=0;all<m;all++){
				for(int all1=0;all1<n;all1++){
					writer.print(A[all][all1]+" ");
					if (all1==n-1)
						writer.print(newLine);
				}
			}
			writer.print(newLine);
			writer.println("b:");
			for(int all=0;all<m;all++){
				writer.print(b[all]+" ");
			}
			writer.print(newLine);
			writer.print(newLine);
			writer.println("c:");
			for(int all=0;all<n;all++){
				writer.print(c[all]+" ");
			}
			writer.print(newLine);
			writer.print(newLine);
			writer.println("Eqin:");
			for(int all=0;all<m;all++){
				writer.print(Eqin[all]+" ");
			}
			writer.print(newLine);
			writer.print(newLine);
			writer.println("MinMax:");
			writer.print(MinMax);
			writer.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createc(String aLine,int size,int[] c){
		char[] x = new char[aLine.length()];
		int thesh =0;
		int i=1;
		int k=0;
		int count=0;
		String number = "";
		for(int j = 0; j < aLine.length(); j++){
			if((aLine.charAt(j)=='+'||(aLine.charAt(j)=='-'))){
			while(Character.isDigit(aLine.charAt(j+i))){
				i++;
				k++;
			}
			for(int l=0;l<k;l++){
				x[thesh]=aLine.charAt(j+l+1);
				thesh++;
			}
			for(int o=0;o<thesh;o++){
				number += x[o];	
			}
			c[count]=Integer.parseInt(number);
			if(aLine.charAt(j)=='-'){
				c[count]=-c[count];
			}
			count++;
			number="";
			i=1;
			k=0;
			thesh=0;
		    }
		}
	}
	
	public static void createbline(String aLine,int line,int[] b){
		int i=1;
		String number = "";
		int k=0;
		int thesh=0;
		char[] x = new char[aLine.length()];
		
		for(int j = 0; j < aLine.length(); j++){
			if(aLine.charAt(j)=='='){
			while((j+i)!=aLine.length()&&aLine.charAt(j+i)!=' '){
				k++;
				i++;
			}
			for(int l=0;l<k;l++){
				x[thesh]=aLine.charAt(j+l+1);
				thesh++;
			}
			for(int o=0;o<thesh;o++){
				number += x[o];	
			}
			if(aLine.charAt(j+1)=='-'){
				b[line]=-b[line];
			}
			b[line]=Integer.parseInt(number);
		    }
		}
	}
	
	public static void createAline(String aLine,int line,int [][] A){
		char[] x = new char[aLine.length()];
		int thesh =0;
		int i=1;
		int k=0;
		int col=0;
		String number = "";
		for(int j = 0; j < aLine.length(); j++){
			if((aLine.charAt(j)=='+'&&aLine.charAt(j-1)!='=')||(aLine.charAt(j)=='-'&&aLine.charAt(j-1)!='=')){
			while(Character.isDigit(aLine.charAt(j+i))){
				i++;
				k++;
			}
			for(int l=0;l<k;l++){
				x[thesh]=aLine.charAt(j+l+1);
				thesh++;
			}
			for(int o=0;o<thesh;o++){
				number += x[o];
			}
			A[line][col]=Integer.parseInt(number);
			if(aLine.charAt(j)=='-'){
				A[line][col]=-A[line][col];
			}
			col++;
			number="";
			i=1;
			k=0;
			thesh=0;
		    }
		}
	}
	
	public static void createEqin(String aLine,int line,int [] Eqin){
		if(aLine.contains("<"))
			Eqin[line]=-1;
		else if (aLine.contains(">"))
			Eqin[line]=1;
		else
			Eqin[line]=0;
	}
	
	public static int createMinMax(String aLine){
		int MinMax =0;
		if(aLine.contains("min"))
			MinMax=-1;
		else if(aLine.contains("max"))
			MinMax=1;
		return MinMax;
	}
	
	
}












