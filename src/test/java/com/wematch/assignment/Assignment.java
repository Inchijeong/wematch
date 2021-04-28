package com.wematch.assignment;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class Assignment {

	@Test
	public void _test1() {
		
		String fileName = "src/test/resources/test_data.txt";
		String targetTime = "13:10:01";
		
		assertThat(getPeopleCnt(fileName, targetTime)).isEqualTo(11);
	}
	
	public int getPeopleCnt(String fileName, String targetTime) {
		int answer = 0;
		
		try {
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			int target = converTimeStringToInt(targetTime);
			
			outer:
			while((line = br.readLine()) != null) {
				String[] newArr = line.split(" ");
				int nowStart = converTimeStringToInt(newArr[0]);
				int nowEnd = converTimeStringToInt(newArr[1]);
				
				if(target < nowStart) {
					continue outer;
				}
				if(target > nowEnd) {
					continue outer;
				}
				answer++;
			}
			br.close();			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return answer;
	}
	
	public int converTimeStringToInt(String timeStr) {
		String[] timeArr = timeStr.split(":");
		return Integer.parseInt(timeArr[0]) * 60 * 60 + Integer.parseInt(timeArr[1]) * 60 + Integer.parseInt(timeArr[2]);
	}
}
