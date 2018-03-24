class Cluster {
    // delegate all calls to get products to the object returned by the call to lazy
    val products: List<Product> by lazy { loadAllTheProducts() }

    private fun loadAllTheProducts(): List<Product> {
        TODO()
    }
}
