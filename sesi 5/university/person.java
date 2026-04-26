public class person {
    protected String name;
    protected String address;
    
    public person(String name, String address){
        this.name =name;
        this.address=address;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String newAddress){
        this.address=newAddress;
    }

    public String toString(){
        return this.name + " ("+this.address+")";
    }
}
