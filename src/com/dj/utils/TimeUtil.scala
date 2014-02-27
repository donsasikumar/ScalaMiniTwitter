package com.dj.utils

import java.util.Calendar
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit
import java.util.Date
import java.util.Date

class TimeUtil {
  
  		val yearFormat = new SimpleDateFormat("yyyy")
		val monthFormat = new SimpleDateFormat("MM")
		val dayFormat = new SimpleDateFormat("dd")
		val minuteFormat = new SimpleDateFormat("mm")
		val hourFormat = new SimpleDateFormat("hh")
		val secondFormat = new SimpleDateFormat("ss")	
  		
  		   var secondsElapsed = 0;
		   var minutesElapsed = 0;
		   var hoursElapsed = 0;
		   var daysElapsed = 0;
		   var timeInfo = ""
		   
  		
  		def getTimeSummary(date:Date)={
  		  			secondsElapsed = getSecondsElapsed(date)
					minutesElapsed = getMinutesElapsed(date)
					hoursElapsed = getHoursElapsed(date)
					daysElapsed = getDaysElapsed(date)
					
					if(daysElapsed>0){
					  timeInfo=daysElapsed+" days ago"
					}
					else if(hoursElapsed>0){
					  timeInfo=hoursElapsed+" hours ago"
					}
					else if(minutesElapsed>0){
					   timeInfo =minutesElapsed+" minutes ago"
					}
					else if(secondsElapsed>0){
					  timeInfo =secondsElapsed+" seconds ago"
					}
  		  			timeInfo
  		}
	
	def getSecondsElapsed(date:Date)={

		val today = Calendar.getInstance().getTime()
		val currentSecond = secondFormat.format(today)  
		val msgSecond = secondFormat.format(date) 
		(currentSecond.toInt-msgSecond.toInt)
	}
	
	def getMinutesElapsed(date:Date)={

		val today = Calendar.getInstance().getTime()
		val currentMinute = minuteFormat.format(today) 
		val msgMinute = minuteFormat.format(date) 
		(currentMinute.toInt-msgMinute.toInt)
	}	
	
	def getHoursElapsed(date:Date)={
		val today = Calendar.getInstance().getTime()
		val currentHour = hourFormat.format(today)  
		val msgHour = hourFormat.format(date) 
		(currentHour.toInt-msgHour.toInt)
	}		
	
	def getDaysElapsed(date:Date)={
		val today = Calendar.getInstance().getTime()
		val currentDay = dayFormat.format(today)  
		val msgDay = dayFormat.format(date) 
		(currentDay.toInt-msgDay.toInt)
	}	
	
}