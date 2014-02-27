package com.dj.actors
import scala.actors.Actor._
import scala.collection.mutable.ListBuffer
import java.util.Calendar

class myActor(name:String) {
  override def toString = name
  var myTuple= Tuple2(Calendar.getInstance().getTime(),"")
  var messages = ListBuffer(myTuple)
  val subscribers = ListBuffer(this)
  messages.clear
  val acts = actor{
    loop{
      receive{
        {
          case x =>myTuple =(Calendar.getInstance().getTime(),x.toString)
        		   messages.append(myTuple)
        }
      }       
    }
    
  }
}