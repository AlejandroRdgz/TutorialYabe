cd3df28e5e523dc9a7e84146946b12f7 ����   4 (  
models/Tag  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this Lmodels/Tag; getCloud ()Ljava/util/Map; 	Signature 5()Ljava/util/Map<Ljava/lang/String;Ljava/lang/Long;>;  tags
    models/Post   _cloud #(Ljava/lang/String;)Ljava/util/Map; findAll ()Ljava/util/List; &()Ljava/util/List<Ljava/lang/String;>;  java/util/ArrayList
    ! " 	_distinct #(Ljava/lang/String;)Ljava/util/Set;
  $  % (Ljava/util/Collection;)V 
SourceFile Tag.java !               /     *� �    
                    	            &      � �    
       1       	            -      � Y� � #�    
       5        &    '