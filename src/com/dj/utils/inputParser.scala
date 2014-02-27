package com.dj.utils

import com.dj.actors.myTwitter

class inputParser() {
     var actor = myTwitter.actor
     var msg = myTwitter.msg
    def getActorFromInput(input:String,endingPattern:String)={
        val start = input.indexOf(':')
    	val end = input.indexOf(endingPattern)
    	actor = input.substring(start+1,end)

    	actor
    }
    
    def getMessageFromInput(input:String)={
        val start = input.indexOf('>')
    	msg = input.substring(start+1)
    	msg  	
    }
    
    def getFollowedUser(input:String)={
      val  start = input.indexOf("follows ")
      val followedUser = input.substring(start+8)
      followedUser
    }  

}