import logo from './logo.svg';
import './App.css';
import { Container, Box, Grid, Typography } from '@material-ui/core';
import Countries from './Countries';

function App() {
  return (
    <Container maxWidth="md">    
      <Box height="100vh"
        display="flex" 
        flexDirection="row"
        alignItems="center"
        justifyContent="center"        
      >
      <Grid container spacing={3}>
        <Grid item xs={12}>                  
          <Typography component="h1" variant="h5">
            Countries
          </Typography>
        </Grid>
          <Grid item xs={12}>                  
            <Countries />
          </Grid>
        </Grid>
      </Box>
    </Container>  
  );
}

export default App;
