        interface MyCamera{
        void takeSnap();
        void recordVideo();
    }

    interface MyWifi{
        String[] getToNetwork();
        void connectToNetwork(String network);
    }
    class MyCellPhone{
        void callNumber(int phoneNumber){
            System.out.println("Calling "+ phoneNumber);
        }
        void pickCall(){
            System.out.println("Connecting....");
        }
        
    }
class MySmartPhone extends MyCellPhone implements MyWifi, MyCamera{
    public void takeSnap(){
            System.out.println("Taking snap");
        }
    public void recordVideo(){
            System.out.println("Recording Video.......");
        }
    public String[] getNetwork(){
            System.out.println("Getting List Of Networks");
            String[] networkList ={"Darshan5G","Bhautik5G","Alfaj5G"};
            return networkList;
        }
    
    public void connectToNetwork(String network){
           System.out.println("Conecting to" + network);
        }
        @Override
    public String[] getToNetwork() {
        return new String[0];
    }
}

class default_method extends MySmartPhone
{
    public static void main (String[] args)
    {
        MySmartPhone ms = new MySmartPhone();
        String[] ar = ms.getNetwork();
        for (String item : ar)
        {
            System.out.println(item);
        }
    }

}