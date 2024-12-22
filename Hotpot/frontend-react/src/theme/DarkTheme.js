import { createTheme } from "@mui/material";

const darkTheme = createTheme({
  palette: {
    mode: "dark",
    primary: {
      main: "#fc8019", 
    },
    secondary: {
      main: "#60b246", 
    },
    black: {
      main: "#171a29",
    },
    background: {
      main: "#343434",
      default: "#343434",
      paper: "#343434",
    },
    textColor: {
      main: "#343434",
    },
  },
});

export default darkTheme;