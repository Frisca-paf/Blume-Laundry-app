package com.example.blume

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SatuanActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Jasa>
    lateinit var namaJasa: Array<String>
    lateinit var harga: Array<String>
    private var jumlah2 : Int = 0
    private var jumlah3 : Int = 0
    private var jumlah1 : Int = 0
    private var jumlah4 : Int = 0
    private var jumlah5 : Int = 0

    private lateinit var totalHarga : TextView
    private var counter = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_satuan)

        totalHarga=findViewById(R.id.total_harga)

        var BackBtn = findViewById<ImageButton>(R.id.backBtn1)
        BackBtn.setOnClickListener {
            intent = Intent (this, LayananActivity::class.java)
            startActivity(intent)
        }

        var BayarBtn = findViewById<Button>(R.id.bayarBtn)
        BayarBtn.setOnClickListener {
            if (counter == 0f) {
                Toast.makeText(applicationContext,"Pilih jasa yang ingin dibeli!", Toast.LENGTH_SHORT).show()
            } else {
                intent = Intent (this, PembayaranActivity::class.java)
                    .putExtra("total", counter)
                startActivity(intent)
            }
        }

        namaJasa = arrayOf(
            "Bed Cover (Kecil)",
            "Bed Cover (Sedang)",
            "Bed Cover (Besar)",
            "Bantal (Kecil)",
            "Bantal (Besar)"
        )

        harga = arrayOf(
            "20000",
            "40000",
            "55000",
            "15000",
            "20000"
        )

        newRecyclerView = findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Jasa>()
        getUserData()
    }

    private fun getUserData() {
        for (i in namaJasa.indices) {
            val jasa = Jasa(namaJasa[i], harga[i])
            newArrayList.add(jasa)
        }

        newRecyclerView.adapter = MyAdapter(newArrayList)

        var tvJumlahReaktif1 = findViewById<TextView>(R.id.jumlah_total1)
        var tvJumlahReaktif2 = findViewById<TextView>(R.id.jumlah_total2)
        var tvJumlahReaktif3 = findViewById<TextView>(R.id.jumlah_total3)
        var tvJumlahReaktif4 = findViewById<TextView>(R.id.jumlah_total4)
        var tvJumlahReaktif5 = findViewById<TextView>(R.id.jumlah_total5)


        val model: PaketViewModel by viewModels()
        val model1: PaketViewModel by viewModels()
        val model2: PaketViewModel by viewModels()


        findViewById<ImageButton>(R.id.plus1).setOnClickListener {
//          jumlah1+=1

//          model.tambahReaktif()
//          model.getJumlahSubject().subscribe { jumlah_total1.setText(it.toString()) }.addTo(disposable)
//          var temp = (model.getJumlahSubject().toString().toFloat())
//          counter= (temp * harga[0].toFloat())
//          totalHarga.text= counter.toInt().toString()

            jumlah1+=1
            tvJumlahReaktif1.setText(jumlah1.toString())
            counter = (jumlah1.toFloat() * harga[0].toFloat()) + (jumlah2.toFloat() * harga[1].toFloat()) + (jumlah3.toFloat() * harga[2].toFloat()) + (jumlah4.toFloat() * harga[3].toFloat()) + (jumlah5.toFloat() * harga[4].toFloat())
            totalHarga.text= "Rp. "+counter.toInt().toString()

        }
        findViewById<ImageButton>(R.id.plus2).setOnClickListener {
            jumlah2+=1
            tvJumlahReaktif2.setText(jumlah2.toString())
            counter = (jumlah1.toFloat() * harga[0].toFloat()) + (jumlah2.toFloat() * harga[1].toFloat()) + (jumlah3.toFloat() * harga[2].toFloat()) + (jumlah4.toFloat() * harga[3].toFloat()) + (jumlah5.toFloat() * harga[4].toFloat())
            totalHarga.text= "Rp. "+counter.toInt().toString()

//            model.tambahReaktif2()
//            model.getJumlahSubject2().subscribe { jumlah_total2.setText(it.toString()) }.addTo(disposable)

        }
        findViewById<ImageButton>(R.id.plus3).setOnClickListener {
//            model.tambahReaktif3()
//            model.getJumlahSubject3().subscribe { jumlah_total3.setText(it.toString()) }.addTo(disposable)
            jumlah3+=1
            tvJumlahReaktif3.setText(jumlah3.toString())
            counter = (jumlah1.toFloat() * harga[0].toFloat()) + (jumlah2.toFloat() * harga[1].toFloat()) + (jumlah3.toFloat() * harga[2].toFloat()) + (jumlah4.toFloat() * harga[3].toFloat()) + (jumlah5.toFloat() * harga[4].toFloat())
            totalHarga.text= "Rp. "+counter.toInt().toString()
        }
        findViewById<ImageButton>(R.id.plus4).setOnClickListener {
//            model.tambahReaktif3()
//            model.getJumlahSubject3().subscribe { jumlah_total3.setText(it.toString()) }.addTo(disposable)
            jumlah4+=1
            tvJumlahReaktif4.setText(jumlah4.toString())
            counter = (jumlah1.toFloat() * harga[0].toFloat()) + (jumlah2.toFloat() * harga[1].toFloat()) + (jumlah3.toFloat() * harga[2].toFloat()) + (jumlah4.toFloat() * harga[3].toFloat()) + (jumlah5.toFloat() * harga[4].toFloat())
            totalHarga.text= "Rp. "+counter.toInt().toString()
        }
        findViewById<ImageButton>(R.id.plus5).setOnClickListener {
//            model.tambahReaktif3()
//            model.getJumlahSubject3().subscribe { jumlah_total3.setText(it.toString()) }.addTo(disposable)
            jumlah5+=1
            tvJumlahReaktif5.setText(jumlah5.toString())
            counter = (jumlah1.toFloat() * harga[0].toFloat()) + (jumlah2.toFloat() * harga[1].toFloat()) + (jumlah3.toFloat() * harga[2].toFloat()) + (jumlah4.toFloat() * harga[3].toFloat()) + (jumlah5.toFloat() * harga[4].toFloat())
            totalHarga.text= "Rp. "+counter.toInt().toString()
        }



        findViewById<ImageButton>(R.id.minus1).setOnClickListener {
            jumlah1-=1
            tvJumlahReaktif1.setText(jumlah1.toString())
            counter = (jumlah1.toFloat() * harga[0].toFloat()) + (jumlah2.toFloat() * harga[1].toFloat()) + (jumlah3.toFloat() * harga[2].toFloat()) + (jumlah4.toFloat() * harga[3].toFloat()) + (jumlah5.toFloat() * harga[4].toFloat())
            totalHarga.text= "Rp. "+counter.toInt().toString()

        }
        findViewById<ImageButton>(R.id.minus2).setOnClickListener {
            jumlah2-=1
            tvJumlahReaktif2.setText(jumlah2.toString())
            counter = (jumlah1.toFloat() * harga[0].toFloat()) + (jumlah2.toFloat() * harga[1].toFloat()) + (jumlah3.toFloat() * harga[2].toFloat()) + (jumlah4.toFloat() * harga[3].toFloat()) + (jumlah5.toFloat() * harga[4].toFloat())
            totalHarga.text= "Rp. "+counter.toInt().toString()

        }
        findViewById<ImageButton>(R.id.minus3).setOnClickListener {
            jumlah3-=1
            tvJumlahReaktif3.setText(jumlah3.toString())
            counter = (jumlah1.toFloat() * harga[0].toFloat()) + (jumlah2.toFloat() * harga[1].toFloat()) + (jumlah3.toFloat() * harga[2].toFloat()) + (jumlah4.toFloat() * harga[3].toFloat()) + (jumlah5.toFloat() * harga[4].toFloat())
            totalHarga.text= "Rp. "+counter.toInt().toString()
        }

        findViewById<ImageButton>(R.id.minus4).setOnClickListener {
            jumlah4-=1
            tvJumlahReaktif4.setText(jumlah4.toString())
            counter = (jumlah1.toFloat() * harga[0].toFloat()) + (jumlah2.toFloat() * harga[1].toFloat()) + (jumlah3.toFloat() * harga[2].toFloat()) + (jumlah4.toFloat() * harga[3].toFloat()) + (jumlah5.toFloat() * harga[4].toFloat())
            totalHarga.text= "Rp. "+counter.toInt().toString()

        }

        findViewById<ImageButton>(R.id.minus5).setOnClickListener {
            jumlah5-=1
            tvJumlahReaktif5.setText(jumlah5.toString())
            counter = (jumlah1.toFloat() * harga[0].toFloat()) + (jumlah2.toFloat() * harga[1].toFloat()) + (jumlah3.toFloat() * harga[2].toFloat()) + (jumlah4.toFloat() * harga[3].toFloat()) + (jumlah5.toFloat() * harga[4].toFloat())
            totalHarga.text= "Rp. "+counter.toInt().toString()

        }

//        counter = (tvJumlahReaktif1.toString().toFloat() * harga[0].toFloat()) + (tvJumlahReaktif2.toString().toFloat() * harga[1].toFloat()) + (tvJumlahReaktif3.toString().toFloat() * harga[2].toFloat())
//        totalHarga.text= counter.toInt().toString()

        totalHarga.text= "Rp. "+counter.toInt().toString()


    }

}
