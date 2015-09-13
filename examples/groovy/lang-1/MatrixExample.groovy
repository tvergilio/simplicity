class Matrix {
    private r1c1, r1c2, r2c1, r2c2
    
    Matrix(r1c1, r1c2, r2c1, r2c2) {
        this.r1c1 = r1c1
        this.r1c2 = r1c2
        this.r2c1 = r2c1
        this.r2c2 = r2c2
    }
    
    Matrix plus(Matrix other) {
        return new Matrix(
                r1c1 + other.r1c1,
                r1c2 + other.r1c2,
                r2c1 + other.r2c1,
                r2c2 + other.r2c2)
    }
    
    Matrix minus(Matrix other) {
        return new Matrix(
                r1c1 - other.r1c1,
                r1c2 - other.r1c2,
                r2c1 - other.r2c1,
                r2c2 - other.r2c2)
    }
    
    Matrix multiply(Matrix other) {
        return new Matrix(
                r1c1 * other.r1c1 + r1c2 * other.r2c1,
                r1c1 * other.r1c2 + r1c2 * other.r2c2,
                r2c1 * other.r1c1 + r2c2 * other.r2c1,
                r2c1 * other.r1c2 + r2c2 * other.r2c2)
    }
    
    String toString() {
        "| ${r1c1} ${r1c2} |\n| ${r2c1} ${r2c2} |"
    }
}

def m1 = new Matrix(1, 0, 0, 1)
def m2 = new Matrix(2, 2, 5, 1)

println m1 + m2
println "--------"
println m2 - m1
println "--------"
println m1 * m2