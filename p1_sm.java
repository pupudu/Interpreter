class p1_sm{
	public static void main(String args[]){
		int k=0;
		for(int a=1;a<1000;a++){
			if(a%3==0||a%5==0)
				k+=a;
		}
	System.out.println(k);
	}
}