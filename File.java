import java.io.*;

public class File
{
    private String input_path;
    private String output_path;

    public File()
    {
        this.input_path = "d://input.txt";
        this.output_path = "d://output.txt";
    }
    public String[] read() throws IOException
    {
        FileInputStream input = null;
        String[] data=null;
        int i=0;
        int array_bound=100000;
        try{
            input = new FileInputStream(input_path);
            DataInputStream dataInputStream = new DataInputStream(input);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            String strLine;
            while ((strLine=bufferedReader.readLine()) != null)
            {
                if(data==null)
                {
                    if(Integer.parseInt(strLine)<=100000)
                        array_bound = Integer.parseInt(strLine);
                    data = new String[array_bound];
                    continue;
                }
                else if(i==array_bound)
                {
                    break;
                }
                data[i] = strLine + (char) 13 + (char) 10;
                i += 1;
            }
        }
        finally
        {
            if(input == null)
            {
                input.close();
            }
        }
        return data;
    }
    public void write(String data, boolean append) throws IOException
    {
        BufferedWriter output = null;
        try
        {
            output = new BufferedWriter(new FileWriter(output_path, append));
            if(data==null)
                output.write("");
            else
                output.write(data + (char) 13 + (char) 10);
            output.close();
        }
        finally
        {
            if(output == null)
            {
                output.close();
            }
        }
    }
}
