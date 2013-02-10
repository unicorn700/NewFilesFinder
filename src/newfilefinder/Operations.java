/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package newfilefinder;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author unicorn
 */
public class Operations {

    private static ArrayList<File> srcFiles = new ArrayList<File>();
    private static ArrayList<String> dstFiles = new ArrayList<String>();
    private static ArrayList<File> diffFiles = new ArrayList<File>();

    public void browse(File directory,int mode)
    {
        File[] files=directory.listFiles();

        if(files==null||files.length==0)
            return;

        for(File ff: files)
          {
              if(ff.isDirectory())
              {
               //  srcFiles.add(ff);
                  browse(ff,mode);
              }
              else
              {
                  if(mode == 0)
                    srcFiles.add(ff);
                  else if(mode == 1)
                      dstFiles.add(ff.getName());
              }
          }
    }


   public void DiffFiles()
   {
       diffFiles.clear();
       Set<String> set1 = new HashSet<String>(dstFiles);

        for (File foo : srcFiles)
        {
            if (!set1.contains(foo.getName()))
            {
                //System.out.println("Found File: "+foo.getName());
                diffFiles.add(foo);
            }
        }
   }


   public static void clearResults()
   {
       srcFiles.clear();
       dstFiles.clear();
   }

   public static ArrayList<File> showResult()
   {
        return diffFiles;
   }
   

}
