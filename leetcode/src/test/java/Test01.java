import org.junit.Test;

/**
 * @Describe
 * @Author aiqiulin
 * @Date 2023/3/29 14:29
 */
public class Test01 {



    @Test
    public void test1(){
        int num=55;
        int[] value=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] ss=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb=new StringBuilder();
        while(num!=0){
            for(int i=0;i<value.length;++i){
                if(num>=value[i]){
                    num-=value[i];
                    sb.append(ss[i]);
                    break;
                }
            }
        }
        System.out.println(sb);
    }






}
