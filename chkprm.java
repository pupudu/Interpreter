import java.lang.Math;
class chkprm{
	public static void main(String[] args){
		chkprm x=new chkprm();
		for(int num=3;num<20;num++){
			if(x.chk(num))
			System.out.println(num);
		}
	}
	boolean chk(int num){
		double rtN=java.lang.Math.sqrt(num);
		for(int i=2;i<=rtN+1;i++){
			if(num%i==0){
				break;
			}
			if(i>=rtN){
				return true;
			}
		}
		return false;
	}
}