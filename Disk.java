public class Disk
{
    private int disk_bound;
    private int[][] disk_array;
    private int range(int tower)
    {
        int range=1;
        for (int i=0; i<disk_bound; i++)
        {
            if (disk_array[i][1] == tower && disk_array[i][2]>range)
            {
                range = disk_array[i][2];
            }
        }
        return range+1;
    }

    public Disk()
    {
        disk_bound = 30000;
        disk_array = new int[disk_bound][3];
        for (int i=0; i<disk_bound; i++)
        {
            disk_array[i][0]=i;
            disk_array[i][1]=i;
            disk_array[i][2]=1;
        }
    }
    public void merge(int x, int y)
    {
        if(x>30000 || y>30000)
            return;
        int old_tower = disk_array[x][1];
        int range = range(disk_array[y][1]);
        for (int i=0; i<disk_bound; i++)
        {
            if(disk_array[i][1]==old_tower)
            {
                disk_array[i][1] = disk_array[y][1];
                disk_array[i][2] = range + (disk_array[i][2] - 1);
            }
        }
    }
    public int height(int x)
    {
        return disk_array[x][2];
    }
}
