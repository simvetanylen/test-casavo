package test.casavo.common

import test.casavo.common.Coordinates

data class RectArea(
    val vector0: Coordinates,
    val vector1: Coordinates,
) {
    fun contains(coordinates: Coordinates): Boolean {
        if (coordinates.latitude > vector1.latitude) {
            return false
        }

        if (coordinates.latitude < vector0.latitude) {
            return false
        }

        if (coordinates.longitude > vector1.longitude) {
            return false
        }

        if (coordinates.longitude < vector0.longitude) {
            return false
        }

        return true
    }
}