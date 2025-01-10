package com.ivoxavier.kaltracker.service.repository.scanner

import android.content.Context
import androidx.compose.ui.res.stringResource
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import com.ivoxavier.kaltracker.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

//context to make the scanner availble anywhere
class BarcodeScanner @Inject constructor (private val context: Context)  {

    //maybe future improvment create an option on the app to choose the barcode type, thus make the scanning faster if user kwows the barcode type
    private val options = GmsBarcodeScannerOptions.Builder()
        .setBarcodeFormats(
            Barcode.FORMAT_ALL_FORMATS
        )
        .build()

    private val scanner = GmsBarcodeScanning.getClient(context, options)
    var barcodeResults = MutableStateFlow<String?>(null)

    suspend fun startScanning(){
            try{
                //val label = scanner.startScan().await()
                scanner.startScan()
                    .addOnSuccessListener { barcode ->
                        barcodeResults.value = barcode.rawValue

                    }
                    .addOnCanceledListener {
                        barcodeResults.value = context.resources.getString(R.string.barcode_canceled_reading)
                    }
            }catch (e: Exception){
                println("Error: ${e.message}")
            }
    }
}