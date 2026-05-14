import java.util.*;
class arp
{
    static int time=0;
    static void addEdge(ArrayList<ArrayList<Integer>>adj,int u,int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static void APUtil(ArrayList<ArrayList<Integer>>adj,int u,boolean vs[],int disc[],int low[],int parent,boolean isAP[])
    {
        vs[u]=true;
        disc[u]=low[u]=++time;
        int children=0;
        for(Integer v:adj.get(u))
        {
            if(!vs[v])
            {
                   children++;
                APUtil(adj,v,vs,disc,low,u,isAP);
                low[u]=Math.min(low[u],low[v]);
                if(parent!=-1&&low[v]>=disc[u])
                {
                    isAP[u]=true;
                }
             

            }
            else if(v!=parent)
            {
                low[u]=Math.min(disc[v],low[u]);
            }
        }
        if(parent==-1&&children>1)
        {
            isAP[u]=true;
        }

    }
    static void AP(ArrayList<ArrayList<Integer>>adj,int V)
    {
        boolean vs[]=new boolean[V];
        int disc[]=new int[V];
        int low[]=new int[V];
        boolean isAP[]=new boolean[V];
        for(int i=0;i<V;i++)
        {
            vs[i]=false;
            isAP[i]=false;
        }
        for(int u=0;u<V;u++)
        {
            if(!vs[u])
            {
                APUtil(adj,u,vs,disc,low,-1,isAP);
            }
        }
        for(int i=0;i<V;i++)
        {
            if(isAP[i])
            {
                System.out.print(i+" ");
            }

        }
    }
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        ArrayList<ArrayList<Integer>>adj1=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj1.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++)
        {
            int s=sc.nextInt();
            int t=sc.nextInt();
            addEdge(adj1,s,t);
        }
        System.out.print("Articulation Points:");
        AP(adj1,V);
    }
}