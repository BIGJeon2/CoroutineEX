package com.example.coroutineex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        println("Start")
//
//        //.await() : 작업이 완료 될 떄 까지 기다린다.
//        GlobalScope.launch (){
//            launch {
//                println("Start")
//            }
//            var value = async {
//                var total = 0
//                for (i in 1..10) total += i
//                total
//            }.await()
//
//            println("Finish : $value")
//        }
//
//
//        //WithContext() : 작업이 완료 될때까지 기다린다.
//        GlobalScope.launch (Dispatchers.IO){
//            val value = withContext(Dispatchers.Main){
//                var total = 0
//                for (i in 1..10){
//                    total += i
//                }
//                total
//            }
//            println("result : $value")
//            println("Finish")
//        }
//
//
//        //runBlocking, .cancel() : 일정 시점에서 작업을 종료한다.
//        val job1 = GlobalScope.launch() {
//            repeat(10){
//                delay(1000)
//                println("Job...Working...")
//            }
//        }
//
//        runBlocking {
//            delay(3000)
//            job1.cancel()
//        }
//
//        println("Finish")
//
//
//        //runBlocking, join() : 작업을 종료 할 때까지 기다린다.
//        val job2 = GlobalScope.launch() {
//            repeat(5) {
//                delay(1000)
//                println("Job...Working...")
//            }
//        }
//
//        runBlocking {
//            delay(3000)
//            job2.join()
//        }
//
//        println("Finish")
//
//
//        //withTimeout : 일정 시점에서 작업을 종료한다.
//        var job5 = GlobalScope.launch {
//            withTimeout(3000) {
//                repeat(10) {
//                    delay(1000)
//                    println("Job Working....")
//                }
//            }
//        }
//        println("Finish")
//
//
//        //Job1과 Job2의 작업을 비동기식으로 처리하는 예제
//        GlobalScope.launch (Dispatchers.Main){
//            val job1 = async (Dispatchers.IO) {
//                var total = 0
//                for (i in 1..5) {
//                    total += i
//                    delay(1000)
//                    println("job1")
//                }
//                total
//            }
//            val job2 = async (Dispatchers.Main){
//                var total = 0
//                for(i in 1..5){
//                    delay(1000)
//                    println("job2")
//                    total += i
//                }
//                total
//            }
//
//            val result1 = job1.await()
//            val result2 = job2.await()
//
//
//
//            println("")
//        }


//        //Channel 기본 예제
//        runBlocking {
//            println("Start")
//            val channel = Channel<Int>()
//            launch {
//                for (i in 1..5) {
//                    channel.send(i + i)
//                }
//
//            }
//                repeat(5){
    //                val result = channel.receive()
    //                println("$result")
    //                }
//
//                println("Finish")
//
//        }

//        //Channel .Cancel() 예제
//        runBlocking {
//            println("Start")
//            val channel = Channel<Int>()
//            launch {
//                for (i in 1..5) {
//                    channel.send(i + i)
//                }
//                channel.close()
//            }
//            for(i in channel) println(i)
//
//            println("Finish")
//
//        }

//        //코루틴 함수로 사용 예제
//        runBlocking {
//            println("Start")
//            val squares = procedureSquares()
//            squares.consumeEach {
//                println("$it")
//            }
//            println("Finish")
//        }
//    }
//    private fun CoroutineScope.procedureSquares() : ReceiveChannel<Int> = produce {
//        for(x in 1..5) send(x+x)


//      //확장함수를 이용한 코루틴 함수 파이프라인 구축 사용 예제
//     runBlocking {
//         println("Start")
//
//         val numbers = productnumbers()
//         val squares = squares(numbers)
//
//         for (i in 1..5){
//             println("Result = ${squares.receive()}")
//         }
//         println("Finish")
//
//         coroutineContext.cancelChildren()
//     }
        //확장함수를 이용한 코루틴 함수 파이프라인 구축 사용 예제2(데이터 생성 , 다중 코루틴)
//        runBlocking {
//            val producer = product()
//            repeat(5){
//                Log.d("repeat : ", "$it")
//                launch(it, producer)
//                joinAll()
//            }
//            delay(1000L)
//            producer.cancel()
//        }
    }
    //확장함수를 이용한 코루틴 함수 파이프라인 구축 사용 예제2(데이터 생성 , 다중 코루틴)
//    fun CoroutineScope.launch(id : Int, channel: ReceiveChannel<Int>){
//        launch {
//            for (msg in channel){
//                println("launch $id received $msg ")
//            }
//        }
//    }
//    //확장함수를 이용한 코루틴 함수 파이프라인 구축 사용 예제2(데이터 생성 , 다중 코루틴)
//    private fun CoroutineScope.product() = produce<Int> {
//        var x = 1
//        while (true){
//            delay(100)
//            println("Send $x - product")
//            send(x++)
//        }
//    }
    //확장함수를 이용한 코루틴 함수 파이프라인 구축 사용 예제
//    private fun CoroutineScope.productnumbers() = produce<Int> {
//        var x = 1
//        while (true){
//            println("Send $x - productumbers")
//            send(++x)
//            delay(100)
//        }
//    }
//      //확장함수를 이용한 코루틴 함수 파이프라인 구축 사용 예제
//    private fun CoroutineScope.squares(numbers : ReceiveChannel<Int>) : ReceiveChannel<Int> = produce{
//        for (x in numbers){
//            println("Send $x - squares")
//            send(x*x)
//        }
//    }
}