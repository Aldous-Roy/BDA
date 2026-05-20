# Install ggplot2 package
install.packages("ggplot2")

# Load ggplot2 package
library(ggplot2)

# Load iris dataset
data(iris)

# Scatter Plot
qplot(Sepal.Length,
      Petal.Length,
      data = iris)

# Scatter Plot with color
qplot(Sepal.Length,
      Petal.Length,
      data = iris,
      color = Species)

# Histogram
hist(iris$Sepal.Length)

# Scatter Plot Matrix
pairs(iris)

# Density Plot
plot(density(iris$Sepal.Length))