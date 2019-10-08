import factory.*;
import tv.*;

public class Main{
	public static void main(String[] args){
		HaierTVFactory haierTVFactory = new HaierTVFactory();
		TV a = haierTVFactory.produceTV();
		
		HisenseTVFactory hisenseTVFactory = new HisenseTVFactory();
		TV b = hisenseTVFactory.produceTV();
		
	}
}