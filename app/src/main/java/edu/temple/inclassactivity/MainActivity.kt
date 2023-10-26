package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        val x = findViewById<Button>(R.id.buttonX).setOnClickListener{
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as ImageDisplayFragment).setImages(imageArray)
        }




        // Attach an instance of ImageDisplayFragment using factory method
        //val someFragment = ImageDisplayFragment.newInstance(imageArray)
        /*
        if(supportFragmentManager.findFragmentById(R.id.fragmentContainerView)!is ImageDisplayFragment)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView,ImageDisplayFragment.newInstance(imageArray))
            .addToBackStack(null)
            .setReorderingAllowed(true)
            .commit()

         */

    }

    /*
    override fun imageSelected(itemId: Int){
        Toast.makeText(this,"You selected $itemId",Toast.LENGTH_SHORT).show()
    }

     */

}