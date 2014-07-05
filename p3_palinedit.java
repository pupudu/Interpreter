class p3_palinedit{
	public static void main(String[] args){
		int ans=0;
		for(int a=999;a>500;a--){
			for(int b=999;b>500;b--){
				int k=a*b;
				String c=Integer.toString(k);
				if(c.charAt(0)==c.charAt(5) && c.charAt(1)==c.charAt(4) && c.charAt(3)==c.charAt(2)){
					if(k>ans){
						ans=k;
					}
				}
			}
		}
		System.out.println(ans);
	}
}