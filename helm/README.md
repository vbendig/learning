# Deploying myapp helm chart to minikube

## Create the helm chart for myapp
```
helm create myapp
```

## Start minikube
```
minikube start
```

## Verify minikube status
```
minikube status
```

## Install the helm app in minikube
```
helm install myapp-cart myapp --values myapp/values.yaml 
```

## Verify deployment
```
kubectx 
 - select context
kubens default
 - select the default namespace
kubectl get po -A
```


## Accessing the nginx
The easiest way to access this service is to let minikube launch a web browser for you:

```
minikube service myapp-chart
```

Alternatively, use kubectl to forward the port:
```
kubectl port-forward service/myapp-chart 7080:8080
```

## LoadBalancer deployments
To access a LoadBalancer deployment, use the “minikube tunnel” command. Here is an example deployment:
```
kubectl create deployment balanced --image=k8s.gcr.io/echoserver:1.4  
kubectl expose deployment balanced --type=LoadBalancer --port=8080
```
In another window, start the tunnel to create a routable IP for the ‘balanced’ deployment:
```
minikube tunnel
```
To find the routable IP, run this command and examine the EXTERNAL-IP column:
```
kubectl get services balanced
```
Your deployment is now available at <EXTERNAL-IP>:8080

