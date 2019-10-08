package factory;
import tv.*;

public class HisenseTVFactory implements TVFactory{
	public TV produceTV(){
		return new HisenseTV();
	}
}