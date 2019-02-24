//https://www.testdome.com/questions/java/path/12283?visibility=1&skillId=4


public class Path {
    private String path;
    public Path(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }
    public void cd(String newPath) {
        String[] nou=newPath.split("/");
        System.out.println("fist");
        System.out.println(nou);
        
        String[] old=path.split("/");
        System.out.println("second");
        System.out.println(old);
        
        int parentcount=0;
        for(String str:nou){
            if(str.equals(".."))
                parentcount++;
        }
        String strnou="";
        for(int i=0;i<old.length-parentcount;i++){
            strnou=strnou+old[i]+"/";
        }
        for(int i=0;i<nou.length;i++){
            if(!nou[i].equals(".."))
                strnou=strnou+nou[i]+"/";
        }
        path=strnou.substring(0, strnou.length()-1);
        System.out.println(path);
        if(path.indexOf("/")<0)
          throw new UnsupportedOperationException("Directory not found");
    }
    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("../x");
        System.out.println(path.getPath());
    }
}
