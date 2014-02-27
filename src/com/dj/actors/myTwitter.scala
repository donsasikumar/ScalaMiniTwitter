package com.dj.actors
import scala.actors.Actor
import scala.collection.mutable.ListBuffer
import com.dj.utils.TimeUtil
import com.dj.utils.TimeUtil
import com.dj.utils.inputParser


object myTwitter {
  
   val Alice = new myActor("Alice")
   val Bob = new myActor("Bob")
   val Charlie = new myActor("Charlie")
   
   val userList = List(Alice,Bob,Charlie)

   val inputParser= new inputParser
   val timeUtil = new TimeUtil
   
   var actor = ""
   var anotherActor = ""
   var msg = ""
   var followedActor = ""

   var timeInfo = ""
   
   
  def main(args:Array[String]){

       println("Enter Input")
	   Iterator.continually(Console.readLine).takeWhile(_ != "exit").foreach(line => twitterFeed(line))  

  }
   
    def twitterFeed(data:String){
    	if(data.startsWith("posting:")){
    		actor = inputParser.getActorFromInput(data,"->")
       		msg = inputParser.getMessageFromInput(data)
    		postAndBroadCastTweet(msg,actor)
    		
    	}
    	if(data.startsWith("wall:")){
    		actor = inputParser.getActorFromInput(data," ")
    		showWall(actor)
    		
    	}
    	if(data.startsWith("following:")){
    	     actor = inputParser.getActorFromInput(data," follows")
    	     anotherActor = inputParser.getFollowedUser(data)
    	     follow(actor, anotherActor)
    }
    	println("Enter an input")
    	
  }

     def postAndBroadCastTweet(line:String,actor:String){
    	 for(i <-userList){
		  		if(actor.equals(i.toString)){
			  		  for(j<-i.subscribers){
						  j.acts!actor+" - "+line
			  		  }
		  		}
		  }

   }   
    
    
    def showWall(actor:String){
      for(i<-userList){
        if(actor.equals(i.toString)){
				for(j <- 0 to i.messages.length-1 reverse){
					timeInfo = timeUtil.getTimeSummary(i.messages(j)._1)
					println(i.messages(j)._2+" ("+timeInfo+" )")
				}
        }
     }
    }
    
def follow(actor:String, anotherActor:String){

      var pointer =0
     if(actor.equals("Alice")){
        pointer = 1
      }
     else if(actor.equals("Bob")){
        pointer = 2
      }
     else if(actor.equals("Charlie")){
        pointer = 3
      }

      for(i<-userList){
        if(anotherActor.equals(i.toString)){
          if(!i.subscribers.contains(actor)){
            pointer match {
              case 1 =>i.subscribers.append(Alice)
              case 2 =>i.subscribers.append(Bob) 
              case 3 =>i.subscribers.append(Charlie)
              case _ => println("Invalid case")
            }
        }
        }
      }

    }

}