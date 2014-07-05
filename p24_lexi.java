import java.lang.String;
import java.util.Arrays;
class p24_lexi{
	public static void main(String[] args){
		int count=0,n=9,L=1000000,count2=0,count3=-1,temp;
		int[] no={0,1,2,3,4,5,6,7,8,9,0,0,0,0,0,0,0,0,0,0,0,0};
		while(count<L-1){
			if(fact(n)<(L-count)){
				count+=fact(n);
				count2++;
				continue;
			}
			count3++;
			System.out.print(no[count2]);
			System.arraycopy(no, (count2+1), no, (count2),9 );
			//System.out.println(Arrays.toString(no));
			count2=0;
			n--;
		}
		System.out.println("60");
	}
	public static int fact(int no){
		if(no==1 || no==0)
			return 1;
		no=no*fact(no-1);
		return no;
	}
}
