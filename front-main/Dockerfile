FROM node:14.15.0-alpine as builder
WORKDIR /usr/src/app
COPY . .
RUN npm install
RUN npm run build
FROM nginx:alpine
COPY --from=builder /usr/src/app/build /usr/share/nginx/html
