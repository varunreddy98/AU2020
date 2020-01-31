import React from 'react';
import Login from './views/Login'
import {Text} from 'react-native';
import {ScrollView} from 'react-native';
import {Image} from 'react-native';
import {ToastAndroid} from 'react-native';
import Dialog, {
  DialogTitle,
  DialogContent,
  DialogFooter,
  DialogButton,
  SlideAnimation,
  ScaleAnimation,
} from 'react-native-popup-dialog';
import { CardViewWithImage } from 'react-native-simple-card-view'
import { Card, CardTitle, CardContent, CardAction, CardButton, CardImage } from 'react-native-material-cards'
import { View, Button } from 'react-native';

export default class App extends React.Component {
  items;
  state={showdialog:false,dialogtitle:'',dialogcontent:'',articles:[],dialogimage:''};
  constructor(props)
  {
    super(props);
  }
  
  componentDidMount = () => {
    fetch('https://api.nytimes.com/svc/topstories/v2/arts.json?api-key=zNcDvnorgNCC6bOqBc3lj8gioAD4FbJO')
    .then((response) => response.json())
    .then((responseJson) => {
       console.log(responseJson);
       this.setState({
          articles: responseJson["results"]
          
       })
    })
    .catch((error) => {
       console.error(error);
    });
  
 }
  
  render() {
    // ToastAndroid.showWithGravityAndOffset(
    //     JSON.stringify(this.state.articles),
    //   ToastAndroid.LONG, 
    //   ToastAndroid.BOTTOM, 
    //   25, 
    //   50 
    // );

    return (
      
      <View>
         { !!this.state.articles.length?
        <ScrollView>
          {this.state.articles.map((article)=> (

         <CardViewWithImage
        width={ (400)}
        content={ article.section }
        source={{ uri: article.multimedia[0].url} }
        title={article.title}
        imageWidth={ 400 }
        imageHeight={ 200 }
        onPress={() => {

          this.setState({showdialog:true,dialogtitle:article.title,dialogcontent:article.abstract,dialogimage:article.multimedia[0].url})

        }}
        roundedImage={ false }
        roundedImageValue={ 50 }
        imageMargin={ {top: 10} }
    />
          ))}
        </ScrollView>:
        <Text>Loading</Text>
      }
        <View>
        <Dialog
        width={1.0}
        height={0.6}
          onDismiss={() => {
            this.setState({ showdialog: false });
          }}
          onTouchOutside={() => {
            this.setState({ showdialog: false });
          }}
          visible={this.state.showdialog}
          dialogTitle={<DialogTitle title={this.state.dialogtitle} />}
          dialogAnimation={new SlideAnimation({ slideFrom: 'bottom' })}>
          <DialogContent>
            <Image
                 style={{width: 400, height:300}}
                 source={{ uri: this.state.dialogimage} }
            />
            <Text>
             {this.state.dialogcontent}
            </Text>
          </DialogContent>
        </Dialog>
        </View>
      </View>
    );
  }
}
