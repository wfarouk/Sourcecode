
library(ISLR)
library(glmnet)
Auto=read.csv("C:/mydataset/10k dirty rowsnotcleanedFullDatasetver5.csv")
names(Auto)

dim(Auto)

class(Auto)

summary(Auto)

#par(mar = rep(2, 4))

#plot(Auto$Malware,Auto$a1)
#?plot()

attach(Auto)
#search()

x=model.matrix(orgLabel~.-1,data=Auto) 
y=Auto$orgLabel


fit.lasso=glmnet(x,y)
plot(fit.lasso,xvar="lambda",label=TRUE)

# Fraction deviance explained - like R Squared
plot(fit.lasso,xvar="dev",label=TRUE)

cv.lasso=cv.glmnet(x,y)
plot(cv.lasso)
which.min(cv.glmnet(x,y))
which.min(cv.lasso)
coef(cv.lasso)

#par(mfrow=c(1,1))

dim(Auto)


# to select random sample from thetrotal dataset for training and rest wil lbe ofr testing

train=sample(seq(10000),7000,replace=FALSE)

train
x[train]
y[train]

lasso.tr=glmnet(x[train,],y[train])
lasso.tr
pred=predict(lasso.tr,x[-train,])
dim(pred)
rmse= sqrt(apply((y[-train]-pred)^2,2,mean))
plot(log(lasso.tr$lambda),rmse,type="b",xlab="Log(lambda)")
points(log(lasso.tr$lambda),rmse,col="blue",pch=19,type="b")
legend("topright",legend=c("Root Mean Square Error"),col=c("blue"),pch=19)

lam.best=lasso.tr$lambda[order(rmse)[1]]
lam.best

coef(lasso.tr, s=lam.best)

plot(coef(lasso.tr, s=lam.best))

## K-Nearest Neighbors
library(class)
?knn
Auto1=read.csv("C:/mydataset/10k dirty rowsnotcleanedFullDatasetver5.csv")

attach(Auto1)
names(Auto1)
#Auto1[414,9]
dim(Auto1)


Xlag=cbind(Auto1$f5,Auto1$f9,Auto1$f27,Auto1$f28,Auto1$f42,Auto1$f43,Auto1$fn2,Auto1$fn3 ,Auto1$fn5 ,Auto1$fn7 ,Auto1$fn9 ,Auto1$fn16 ,Auto1$fn17 ,Auto1$fn27 ,Auto1$fn42 ,Auto1$fn43 ,Auto1$fn46, Auto1$orgLabel)


#train=Year<2005
train1=sample(seq(10000),7000,replace=FALSE)
train1

dim(Xlag)
Xlag[1:5,]
Auto1[1:5,]
Auto1$orgLabel[train1]

knn.pred=knn(Xlag[train1,],Xlag[!train1,],Auto1$f1[train1],k=1)

knn.pred

table(knn.pred,Auto1$orgLabel[!train1])
mean(knn.pred==Auto1$orgLabel[!train1])




