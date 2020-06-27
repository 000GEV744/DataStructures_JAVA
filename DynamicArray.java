public class DynamicArray
{
    private int len; //length upto which my array is filled up
    private int capacity; //actual size of the array initally
    private Integer [] array; //static array used for dynamic array creation
    
    public DynamicArray(){
        this(10);
    }
    
    public DynamicArray(int capacity){
        if(capacity<0) {
            throw new IllegalArgumentException("Illegal capacity "+capacity);
        }
        this.capacity = capacity;
        this.array = new Integer[this.capacity];
    }
	
	//return the size of the array 
	private int getCapacity(){
	 return this.capacity;
	}
    
	//return the number of elements
	private int getElemeentCount(){
		return this.len;
	}
    
	//add a new data 
    private void add(int data){
        if(this.len == this.capacity){
            this.growSize();
        }
        this.array[this.len] = data;
		System.out.println(this.array[this.len]+ " added ");
        len++;
    }
    
    //add a new data to a particular index 
    private void addAtIndex(int index, Integer data){
        if(index>=len && index<0){
            throw new IndexOutOfBoundsException();
        }
        
        if(this.len == this.capacity){
            this.growSize();
        }
        
        for(int i = len; i > index;i--){
            this.array[i] = this.array[i-1];
        }
        
        this.array[index] = data;
        this.len++;
    }
    
    //new static array of double it's earlier siz is created.
    private void growSize(){
        Integer [] temp = null;
        if(this.len == this.capacity){
            temp = new Integer[2*capacity];
            for(int i = 0; i < this.capacity; i++){
                temp[i] = this.array[i];
            }
        }
        this.array = temp;
        capacity = 2*capacity;
    }
    
    //remove the last element form the dynnamic array
    private void remove(){
        if(this.len > 0){
            this.array[this.len-1] = null;
            this.len--;
        }
    }
    
    //remove from a particular index
    private void removeAtIndex(int index){
		if(index>=len && index<0){
		throw new IndexOutOfBoundsException();
		}
        for(int i = index; i <= this.len-2; i++){
            this.array[i] = this.array[i+1];
        }
		this.array[this.len-1]=null;
        this.len--;
    }
	
	//clear out the extra void space of the dynamic array
	private void shrinkArray(){
	if(this.capacity == this.len){
	System.out.println("Error :: Array can't be shrinked as there is no void in the array");
	}
	if(this.len<this.capacity){
	Integer [] temp = new Integer[this.len];
    for(int i = 0; i < this.len; i++){
		temp[i] = this.array[i];
	}
	this.capacity = this.len;
	this.array = temp;
	}
	}
	
    
	public static void main(String[] args) {
	
	DynamicArray dm = new DynamicArray();
	
	dm.add(9);
	dm.add(2);
	dm.add(-9);
	dm.add(44);
	dm.add(23);
	dm.add(2);
	dm.add(5);
	dm.add(6);
	dm.add(1);
	dm.add(11);
	dm.add(63);
	dm.add(19);
	dm.add(15);
	dm.add(32);
	
	// print all array elements after adding
	System.out.println("Elements of array:");
	for(int i = 0; i < dm.getCapacity(); i++){
		System.out.print(dm.array[i]+ " ");
	}
	
	//print the size of the array 
	System.out.println("\nSize of the dynamic array is :" + dm.getCapacity());
	System.out.println("number of elements " + dm.getElemeentCount());
	
	//going to shrink the array incase extra space is occupied and no elements are stored
	dm.shrinkArray();
	
	// print all array elements after adding
	System.out.println("Elements of array:");
	for(int i = 0; i < dm.getCapacity(); i++){
		System.out.print(dm.array[i]+ " ");
	}
	
	//add new data at an index 
	dm.addAtIndex(1,22);
	dm.addAtIndex(2,23);
	
	// print all array elements after adding at new index.
	System.out.println("\nElements of array:");
	for(int i = 0; i < dm.getCapacity(); i++){
		System.out.print(dm.array[i]+ " ");
	}
	
	
	dm.remove();
	dm.remove();
	
	// print all array elements after remove operation
	System.out.println("\nElements of array:");
	for(int i = 0; i < dm.getCapacity(); i++){
		System.out.print(dm.array[i]+ " ");
	}
	
	dm.removeAtIndex(11);
	// print all array elements after removing data from some index
	System.out.println("\nElements of array:");
	for(int i = 0; i < dm.getCapacity(); i++){
		System.out.print(dm.array[i]+ " ");
	}
	dm.removeAtIndex(112);
	
	
}
}
