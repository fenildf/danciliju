import sun.net.www.http.HttpClient;

import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        /**
         *抓的网站
        */
        String string = "http://www.iciba.com/";
        /**
         * 要抓的单词
         */
        String word;
        /**
         * 抓的单词的文本文件
         */
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/admin/IdeaProjects/pachong/src/word/sijiword"));
        word = bufferedReader.readLine();
        int j = 1;
        while (word != null) {
            j++;
            /**
             * 去掉txt中的解释,得到要搜的单词
             */
            String[] strings = word.split(" ", 2);
            if (strings.length < 2) {
                word = bufferedReader.readLine();
                continue;
            }
            for (int i = 0; i < strings.length; i++) {
                System.out.println(i + "  " + strings[i]);
            }
            /**
             * 访问网站,得到html放入inputstream中
             */
            InputStream inputStream = Wordpachong.pachong(string + strings[0]);
            /**
             * 筛选inputstream.得到例句
             */
            Wordshaixuan.shaixuan(inputStream, strings[0], strings[1]);
            word = bufferedReader.readLine();
        }

        /*InputStream inputStream = Wordpachong.pachong(string + word);
        Wordshaixuan.shaixuan(inputStream);*/
    }
}
