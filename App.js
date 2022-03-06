import { View, Text, StyleSheet, TextInput, Button, Keyboard } from 'react-native'
import React, { useState } from 'react'
import LinearRegression from './LinearRegression';

function onPressEvent(input){
  Keyboard.dismiss();
  LinearRegression.linearRegression(input);
}

const App = () => {

  const [input, setinput] = useState("0");

  return (
    <View style={styles.app}>
      <Text style={styles.title}>Linear Regression</Text>
      <TextInput
        style={styles.input}
        onChangeText={setinput}
        value={input}
        placeholder="enter a number"
        keyboardType="numeric"
      />
      <Button
        style={styles.btn}
        title="Press me"
        onPress={() => onPressEvent(input) }
      />
      <Text style={styles.describtion}>f(x) = x * 2</Text>
    </View>
  )
}

const styles = StyleSheet.compose({

  app:{
    justifyContent: "center",
    flex:1,
  },  

  input:{
    height: 40,
    margin: 12,
    borderWidth: 1,
    padding: 10,
  },

  title:{
    fontWeight:"bold",
    textAlign:"center",
    fontSize:30,
  },

  describtion:{
    fontWeight:"600",
    textAlign:"center",
    fontSize:15,
    marginTop:10,
  },

  btn:{
    width:100,
  },

})

export default App