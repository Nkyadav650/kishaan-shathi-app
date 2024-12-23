const validate = (values, context) => {
  const errors = {};
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/i;

  // Common password validation logic
  const validatePassword = (password) => {
      if (!password) {
          return "Password is required";
      } else if (password.length < 4) {
          return "Password must be more than 4 characters";
      } else if (password.length > 10) {
          return "Password cannot exceed more than 10 characters";
      }
      return null;
  };

  // Context-specific validation
  if (context === 'login') {
      if (!values.username) {
          errors.username = "Username is required";
      }
      const passwordError = validatePassword(values.password);
      if (passwordError) errors.password = passwordError;
  }

  if (context === 'signup') {
      if (!values.name) {
          errors.name = "Name is required!";
      }
      if (!values.userId) {
        errors.userId = "userid is required!";
    }
      if (!values.email) {
          errors.email = "Email is required!";
      } else if (!emailRegex.test(values.email)) {
          errors.email = "This is not a valid email format!";
      }
      if (!values.phoneNumber) {
          errors.phoneNumber = "Phone number is required!";
      }
      const passwordError = validatePassword(values.password);
      if (passwordError) errors.password = passwordError;
  }

  return errors;
};

export default validate;
