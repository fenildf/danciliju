import java.io.*;

/**
 * Created by admin on 16/2/19.
 */
public class Wordshaixuan {
    /**
     * 两个div标签,是例句在html中的位置
     */
    public static final String LIJU="<p class='p-english family-english size-english'>";
    public static final String JIESHI="<p class='p-chinese family-chinese size-chinese'>";

    /**
     * 把html中内容,与标签做匹配.然后调用函数写入文件中
     * @param inputStream 传入的html
     * @param word 单词
     * @param mean  解释
     * @throws IOException
     */
    public static void shaixuan(InputStream inputStream,String word,String mean) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String string = " ";
        String liju ="";
        int k=1;
        while (string!=null&&k<4){
            if(string.indexOf(LIJU)>=0){
                String[] str =string.split("(<)");
                for(int i = 0 ; i<str.length;i++) {

                    String string2 =str[1];
                    String[] str2 =string2.split("(>)",2);
                    System.out.println(str2[1]);
                    liju=liju+str2[1];
                    break;
                }
                }
            if(string.indexOf(JIESHI)>=0){
                String[] str =string.split("(<)");
                for(int i = 0 ; i<str.length;i++) {

                    String string2 =str[1];
                    String[] str2 =string2.split("(>)",2);
                    System.out.println(str2[1]);
                    liju=liju+str2[1];
                    k++;
                    break;
                }
            }


            string = bufferedReader.readLine();

        }
    /*    bufferedWriter.write(word+"*"+mean+"*"+liju);
        bufferedWriter.newLine();*/
        setWord(liju,word,mean);

    }

    /**
     * 将内容写入sijiword4文件中
     * @param string 例句
     * @param word 单词
     * @param mean 解释
     * @throws IOException
     */
    private static void  setWord(String string,String word,String mean) throws IOException {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/admin/IdeaProjects/pachong/src/word/sijiword4",true));
            bufferedWriter.write(word+"*"+mean+"*"+string);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }


}
