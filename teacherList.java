package dsproject;

public class teacherList{
    courseList[] Table;

    public teacherList(int s){
        int size = s+(s/3);
        int newSize = getPrime(size);
        Table = new courseList[newSize];
    }
    private int getPrime(int n){
        while(true){
            if(isPrime(n)) 
            return n;
            
            n++;
        }
    }
    private boolean isPrime(int n){
        for(int i=2; i<=n/2; i++){
            if(n%i==0)
            return false;
        }
        return true;
    }
    //returns numeric value for String
    public int hashStr(String s) {
        int g = 31;
        int  hash = 0;
        for(int i=0; i<s.length();i++){
            hash = g * hash + s.charAt(i);
        }
        return hash;       
}
    public void insertCourseList(String s, courseList courses){
        int StrHashValue = Math.abs(hashStr(s));
        int index = Hash(StrHashValue);
        if(Table[index]==null){
        Table[index] = courses;
        }
        else{
            int limit = 0;
            int i = 1;
            while(Table[index]!=null && limit<10){
            index = Rehash(StrHashValue, i); //linear probing i*i for quadratic
            i++;    
            limit++;
            }
            if(Table[index]==null){
            Table[index] = courses;
            }
            else
            System.out.println("Limit for Rehash reached");
        }
    }
    //returns hash value for string numeric value
    public int Hash(int StrHashValue){
        return StrHashValue%Table.length;
    }
    public int Rehash(int StrHashValue, int i){
        return (StrHashValue+i)%Table.length;
    }

    public Ratings search(String TeacherName, String courseName){
        int StrHashValue = Math.abs(hashStr(TeacherName));
        int HashValue = Hash(StrHashValue);
        if(Table[HashValue]==null){
            System.out.println("Teacher not found");
            return null;
        }
        else if(Table[HashValue].name.equals(TeacherName)){
            return Table[HashValue].search(courseName);
        }
        else{
            int limit = 0;
            int i = 1;
            while(Table[HashValue]!=null && limit<10 && !Table[HashValue].name.equals(TeacherName)){
            HashValue = Rehash(StrHashValue, i); //linear probing i*i for quadratic
            i++;    
            limit++;
            }
            if(Table[HashValue]==null || limit==10){
                System.out.println("Teacher not found");
                return null;
            }
            else{
            return Table[HashValue].search(courseName);
            }
        }
   } 
}

