package com.example.libraryVerdi.boot.utils;

public enum StatusSession {

    AVAILABLE  {
        @Override
        public String toString() {
          return "Available";
        }},
    RENTED {
        @Override
        public String toString() {
          return "Rented";
        }},
}