import java.io.IOException;

public class Main
{
    public static void main(String[] args)  throws IOException
    {
        File file = new File();
        file.write(null , false);
        Disk disk = new Disk();
        String[] construction = file.read();
        String[] job = new String[3];
        int j=0;
        int x;
        int y;
        String output="";

        for (String my_construction:construction)
        {
            j=0;
            job[0]="";
            job[1]="";
            job[2]="";
            for (int i = 0; i < my_construction.length(); i++)
            {
                if (!Character.isWhitespace(my_construction.charAt(i)))
                {
                    job[j] += String.valueOf(my_construction.charAt(i));
                }
                else
                {
                    j+=1;
                    if(j>2)
                        break;
                }
            }
            if(job[0].equals("Height"))
            {
                x = Integer.parseInt(job[1]);
                output = String.valueOf(disk.height(x));
                System.out.println(output);
                file.write(output, true);
            }
            else if(job[0].equals("Merge"))
            {
                x = Integer.parseInt(job[1]);
                y = Integer.parseInt(job[2]);
                disk.merge(x, y);
            }
        }
    }
}
