# Install package (run only once)
install.packages("ggplot2")

# Load library
library(ggplot2)

# Load dataset
data(iris)

# 1. Scatter Plot
qplot(Sepal.Length, Petal.Length, data = iris)

# 2. Histogram
hist(iris $Sepal.Length)

# 3. Bar Plot
qplot(Species, data = iris)

# 4. Box Plot
qplot(Species, Sepal.Length, data = iris, geom = "boxplot")

# 5. Line Plot
qplot(1:nrow(iris), Sepal.Length, data = iris, geom = "line")

# 6. Density Plot
qplot(Sepal.Length, data = iris, geom = "density")

