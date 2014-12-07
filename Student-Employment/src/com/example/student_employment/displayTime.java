package com.example.student_employment;


public class displayTime {
	public displayTime(){
		super();
	}
	public String selectDayOfWeek(int dow,String timeString){
		String timeString2="";
		if(dow>=1 && dow<=7){
			if (dow==1){
				ViewHours.dows="Monday";
				timeString2=timeString.substring(0,48);}
			if (dow==2){
				ViewHours.dows="Tuesday";
				timeString2=timeString.substring(48,96);}
			if (dow==3){
				ViewHours.dows="Wednesday";
				timeString2=timeString.substring(96,144);}
			if (dow==4){
				ViewHours.dows="Thursday";
				timeString2=timeString.substring(144,192);}
			if (dow==5){
				ViewHours.dows="Friday";
				timeString2=timeString.substring(192,240);}
			if (dow==6){
				ViewHours.dows="Saturday";
				timeString2=timeString.substring(240,288);}
			if (dow==7){
				ViewHours.dows="Sunday";
				timeString2=timeString.substring(288);}
		}
		else
			System.out.println("Day of week takes 1-7 as Monday-Sunday.");
		
		return timeString2;
	}

	public String timePeriod(String timeString){
		String result="";
		int hour=0;
		int minute=0;
		for(int i=0;i<timeString.length();i++){
			int j,k;
			if(i>0){
				j=i-1;
			}
			else{
				j=i;
			}
			if(i<timeString.length()-1){
				k=i+1;
			}
			else{
				k=i;
			}
			
			
			if(timeString.charAt(i)=='1' && i==0){
				result+="From "+String.format("%02d", hour)+":"+String.format("%02d",minute);
			}
			if(timeString.charAt(j)=='0' && timeString.charAt(i)=='1'){
				result+="From "+String.format("%02d", hour)+":"+String.format("%02d",minute);
			}
			minute+=30;
			if(minute==60){
				minute=0;
				hour+=1;
			}
			if(timeString.charAt(i)=='1' && timeString.charAt(k)=='0'){
				result+=" To "+String.format("%02d", hour)+":"+String.format("%02d",minute)+"\n";
			}
			if(timeString.charAt(i)=='1' && i==timeString.length()){
				result+=" To "+String.format("%02d", hour)+":"+String.format("%02d",minute)+"\n";
			}
			
		}
		return result;
	}
	
}
