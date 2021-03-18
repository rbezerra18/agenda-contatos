package jr.roberto.agendacontatos

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact (
    var name : String,
    var phone : String,
    var photografy : String
    ) : Parcelable