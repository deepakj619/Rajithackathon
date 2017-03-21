public class User {
    //name and address string
    private int aadhar;
    private int bankno;
    private int number;

    public User() {
      /*Blank default constructor essential for Firebase*/
    }
    //Getters and setters
    public int getAadhar() {
        return aadhar;
    }

    public void setAadhar(int aadhar) {
        this.aadhar = aadhar;
    }

    public int getbankno() {
        return bankno;
    }

    public void setBankno(int bankno) {
        this.bankno = bankno;
    }
    public int getNumber(){

        return number;
    }
    public void setNumber(int number){

        this.number=number;
    }
}
