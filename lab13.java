import java.util.ArrayList;
import java.util.StringTokenizer;
public class lab13 {
	ArrayList<Integer> list = new ArrayList<>();
	public void readData(String filename) {
		try {
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			String inn;
			while((inn=input.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(inn,"\t");
				while(st.hasMoreTokens()) {
					String newToken = st.nextToken();
					int c = Integer.valueOf(newToken);
					list.add(c);
				}
			}
			input.close();
		}catch(Exception e) {
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	public long getTotalCount() {
		return list.stream().count();
	}
	public long getOddCount() {
		 return list.stream().filter(x -> x % 2 == 1).count();
	}
	public long getEvenCount() {
		return list.stream().filter(x -> x % 2 == 0).count();
	}
	public long getDistinctGreaterThanFiveCount() {
		return list.stream().distinct().filter(x -> x > 5).count();
	}
	public Integer[] getResult1() {
		return list.stream().filter(x -> x>5).filter(x -> x<50).filter(x -> x%2 ==0).sorted().toArray(Integer[]::new);
	}
	public Integer[] getResult2() {
		return list.stream().limit(50).map(x -> 3*x*x).toArray(Integer[]::new);
	}
	public Integer[] getResult3() {
		return list.stream().filter(x -> x%2 ==1).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
}
