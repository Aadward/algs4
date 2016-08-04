package sundry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import util.MinPQ;
import util.StopWatch;
import util.StopWatch.TimeConvert;
import algs4.ResizingArrayQueue;

public class FileSort {
	private static final int MAX_ROWS_PER_FILE = 10000;
	private static final int LOAD_ROWS_PER_TIME = 100;
	private static final int WRITE_BUFFER_SIZE = 10000;
	
	private String filePath;
	public FileSort(String filePath){
		this.filePath = filePath;
	}
	
	public void sort(){
		List<String> fileNames = splitFile();
		BufferedWriter bw = null;
		BufferedReader[] brs = new BufferedReader[fileNames.size()];
		try{
			@SuppressWarnings("unchecked")
			ResizingArrayQueue<MetaData>[] queues = new ResizingArrayQueue[fileNames.size()];
			//初始化缓存队列,load一部分数据
			for(int i = 0; i < fileNames.size(); i++){
				try {
					brs[i] = new BufferedReader(new FileReader(fileNames.get(i)));
					queues[i] = loadData(i, brs[i]);
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
			MinPQ<MetaData> minpq = new MinPQ<FileSort.MetaData>(fileNames.size());
			for(int i = 0; i < fileNames.size(); i++){
				minpq.insert(queues[i].dequeue());
			}
			File inFile = new File(filePath);
			String outFilePath = inFile.getParent() + "\\" + inFile.getName().split("\\.")[0] + "_output" + "." + inFile.getName().split("\\.")[1];
			File outFile = new File(outFilePath);
			//输出流
			bw = new BufferedWriter(new FileWriter(outFile));
			String[] buffer = new String[WRITE_BUFFER_SIZE];
			while(minpq.size() > 0){
				int count = 0;
				while(count < WRITE_BUFFER_SIZE && minpq.size() > 0){
					MetaData data = minpq.delMin();
					int i = data.id;
					if(queues[i].size() <= 0){
						queues[i] = loadData(i, brs[i]);
					}
					if(queues[i].size() > 0){
						minpq.insert(queues[i].dequeue());
					}
					buffer[count++] = data.value;
				}
				for(int i = 0; i < count; i++){
					bw.write(buffer[i]);
					bw.newLine();
				}
				System.out.println("写入输出文件个数：" + count);
				bw.flush();
			}
		}catch(Throwable t){
			t.printStackTrace();
		}finally{
			try{
				for(BufferedReader br : brs){
					br.close();
				}
				bw.close();
			}catch(Throwable t){
				t.printStackTrace();
			}
		}
		
		
	}	
	
	/**
	 * 将大文件分割成若干个小文件
	 * @return newFileNames
	 */
	private List<String> splitFile(){
		List<String> ret = new ArrayList<String>();
		List<String> buf = new ArrayList<String>();
		File inFile = new File(filePath);
		BufferedReader br = null;
		BufferedWriter bw = null;
		try{
			br = new BufferedReader(new FileReader(inFile));
			int count = 0;
			String temp = null;
			while((temp = br.readLine()) != null){
				String outputFilePath = inFile.getParent() + "\\" + inFile.getName().split("\\.")[0] + "_" + (count++) + "." + inFile.getName().split("\\.")[1];
				ret.add(outputFilePath);
				File oFile = new File(outputFilePath);
				if(!oFile.exists()){
					oFile.createNewFile();
				}
				bw = new BufferedWriter(new FileWriter(outputFilePath));
				buf.add(temp);
				for(int i = 0; i < MAX_ROWS_PER_FILE - 1; i++){
					temp = br.readLine();
					if(temp == null){
						break;
					}else{
						buf.add(temp);
					}
				}
				Collections.sort(buf, new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						if(o1.length() > o2.length()){
							return 1;
						}else if(o1.length() < o2.length()){
							return -1;
						}else{
							return o1.compareTo(o2);
						}
					}
				});
				for(String str : buf){
					bw.write(str);
					bw.newLine();
				}
				buf.clear();
				bw.flush();
				bw.close();
			}
		}catch(Throwable t){
			t.printStackTrace();
		}finally{
			try{
				if(br != null){
					br.close();
				}
				if(bw != null){
					bw.close();
				}
			}catch(Throwable t){
				t.printStackTrace();
			}
		}
		return ret;
	}
	
	/**
	 * 获得加载完毕的队列
	 * @param id
	 * @param br
	 * @return  queue
	 */
	private ResizingArrayQueue<MetaData> loadData(int id, BufferedReader br){
		ResizingArrayQueue<MetaData> queue = new ResizingArrayQueue<FileSort.MetaData>(100);
		for(int i = 0; i < LOAD_ROWS_PER_TIME; i++){
			try{
				String value = br.readLine();
				if(value == null || value == ""){
					break;
				}else{
					queue.enqueue(new MetaData(id, value));
				}
			}catch(Throwable t){
				t.printStackTrace();
			}
		}
		return queue;
	}
	
	public class MetaData implements Comparable<MetaData>{
		public final int id;
		public final String value;
		public MetaData(int id, String value){
			this.id = id;
			this.value = value;
		}
		@Override
		public int compareTo(MetaData o) {
			String thisValue = this.value;
			String thatValue = o.value;
			if(thisValue.length() > thatValue.length()){
				return 1;
			}else if(thisValue.length() < thatValue.length()){
				return -1;
			}else{
				return thisValue.compareTo(thatValue);
			}
		}
	}
	
	public static void generateData(String path,int max){
		if(path == null || path.equals("")){
			path = "D:/filesort/test.txt";
		}
		File file = new File(path);
		FileWriter os;
		try {
			os = new FileWriter(file);
			Random rand = new Random(47);
			for(int i = 0; i < max; i++){
				os.append(rand.nextInt(Integer.MAX_VALUE) + "\r\n");
			}
			os.close();
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		generateData(null,10);
		StopWatch sw = new StopWatch();
		FileSort fileSort = new FileSort("D:/filesort/test.txt");
		fileSort.sort();
		System.out.println("共计用时：" + sw.elapsedTime(TimeConvert.SECOND) + "秒");
	}
}
