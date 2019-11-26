class ProducerConsumerDemo{
	public static void main(String[] args){
		
		Resource r=new Resource();
		
		Producer pro =new Producer(r);
		Consumer con =new Consumer(r);
		
		Thread t1=new Thread(pro);
		Thread t2=new Thread(pro);
		Thread t3=new Thread(con);
		Thread t4=new Thread(con);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
 
// 共同操作资源类
class Resource{
	private String name;
	private int count=1;
	private boolean flag=false;
	// 生产者方法,运算生产
	public synchronized void set(String name){
		while(flag){	// if用于单组生产者消费者
			try{this.wait();}catch(Exception e){}
		}
		this.name=name+"--"+count++;
		
		System.out.println(Thread.currentThread().getName()+"...生产者.."+this.name);
		flag=true;
		this.notifyAll();	// notify()用于单组生产者消费者
	}
	// 消费者方法，输出消费
	public synchronized void out(){
		while(!flag){
			try{this.wait();}catch(Exception e){}
		}
		
		System.out.println(Thread.currentThread().getName()+"...消费者........"+this.name);
		flag=false;
		this.notifyAll();
	}
}
// 生产者线程
class Producer implements Runnable{
	
	private Resource res;
	
	Producer(Resource res){
		this.res=res;
	}
	
	public void run(){
		while(true){
			res.set("+商品+");
		}
	}
}
// 消费者线程
class Consumer implements Runnable{
	
	private Resource res;
	
	Consumer(Resource res){
		this.res=res;
	}
	
	public void run(){
		while(true){
			res.out();
		}
	}
}
