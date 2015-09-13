// The problem
println 2.0D - 1.1D

// The Java solution
println "-- Java --"
System.out.println(new BigDecimal("2.0").subtract(new BigDecimal("1.1")));

// The Groovy solution
println "-- Groovy --"
println 2.0 - 1.1






/*
// Number types
println 2.0.class

println 2.class
println 2G.class

// Comparing numbers
assert 2.0 == 2.000
assert !(2.0.equals(2.000))
assert 2.0.compareTo(2.000) == 0
assert !2.0.is(2.000)

def num = 2.00
assert num.is(num)
*/
