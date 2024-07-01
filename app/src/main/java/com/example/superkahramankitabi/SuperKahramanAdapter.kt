package com.example.superkahramankitabi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superkahramankitabi.databinding.RecyclerRowBinding

//Yani SuperKahramanAdapteri oluşturulmaya çalışıldığında benden superKahramanListesini isteyecvek.
class SuperKahramanAdapter(val superKahramanListesi : ArrayList<SuperKahraman>): RecyclerView.Adapter<SuperKahramanAdapter.SuperKahramanViewHolder>() {
//SuperKahramanApaterı implement ettiğimiz zaman bize 3 tane fonksiyon veriyor uygulamak için zorunlu olarak onCreateViewHolder,getItemCount,onBindViewHolder
    class SuperKahramanViewHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }


//RecyclerViewRowBindingi uygulamak için yani viewholderın bir objesini oluşturmak için
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperKahramanViewHolder {


        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SuperKahramanViewHolder(binding)

    }

    //oluşturduğumuz recylerviewrowdan kaç tane yapayım diye soruyor mesela kaç süper kahraman varsa o kadar yani array liste kaç tane varsa o kadar
    //listemin içinde ne kadar varsa o kadar göster
    override fun getItemCount(): Int {
        return superKahramanListesi.size


    }

    //işlemer bitince ne yapacağız şunu göster bunu göster tıklanınca şunu yap tıklanmazsa bunu yap gibi
    override fun onBindViewHolder(holder: SuperKahramanViewHolder, position: Int) {
        //Recyclerviewe ulaşıyoruz.
        holder.binding.textViewRecyclerView.text = superKahramanListesi[position].isim

        //tıklatıldığında açma işlemi
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,TanitimAktivitesi ::class.java)
            intent.putExtra("secilenKahraman" ,superKahramanListesi[position] )
            holder.itemView.context.startActivity(intent)
        }
    }


}