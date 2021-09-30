package com.example.coroutineex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Start")

        //.await() : 작업이 완료 될 떄 까지 기다린다.
        GlobalScope.launch (){
            launch {
                println("Start")
            }
            var value = async {
                var total = 0
                for (i in 1..10) total += i
                total
            }.await()

            println("Finish : $value")
        }


        //WithContext() : 작업이 완료 될때까지 기다린다.
        GlobalScope.launch (Dispatchers.IO){
            val value = withContext(Dispatchers.Main){
                var total = 0
                for (i in 1..10){
                    total += i
                }
                total
            }
            println("result : $value")
            println("Finish")
        }


        //runBlocking, .cancel() : 일정 시점에서 작업을 종료한다.
        val job1 = GlobalScope.launch() {
            repeat(10){
                delay(1000)
                println("Job...Working...")
            }
        }

        runBlocking {
            delay(3000)
            job1.cancel()
        }

        println("Finish")


        //runBlocking, join() : 작업을 종료 할 때까지 기다린다.
        val job2 = GlobalScope.launch() {
            repeat(5) {
                delay(1000)
                println("Job...Working...")
            }
        }

        runBlocking {
            delay(3000)
            job2.join()
        }

        println("Finish")


        //withTimeout : 일정 시점에서 작업을 종료한다.
        var job5 = GlobalScope.launch {
            withTimeout(3000) {
                repeat(10) {
                    delay(1000)
                    println("Job Working....")
                }
            }
        }
        println("Finish")


        //Job1과 Job2의 작업을 비동기식으로 처리하는 예제
        GlobalScope.launch (Dispatchers.Main){
            val job1 = async (Dispatchers.IO) {
                var total = 0
                for (i in 1..5) {
                    total += i
                    delay(1000)
                    println("job1")
                }
                total
            }
            val job2 = async (Dispatchers.Main){
                var total = 0
                for(i in 1..5){
                    delay(1000)
                    println("job2")
                    total += i
                }
                total
            }

            val result1 = job1.await()
            val result2 = job2.await()

            println("result1 : $result1, result2 : $result2")
        }

    }
}